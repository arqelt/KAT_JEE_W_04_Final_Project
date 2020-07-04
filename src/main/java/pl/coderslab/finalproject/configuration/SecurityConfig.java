package pl.coderslab.finalproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.coderslab.finalproject.service.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/home").authenticated()
                .antMatchers("/facility/all","/facility/add","/facility/edit").hasAnyRole("USER", "ADMIN")
                .antMatchers("/facility/delete","/facility/askForDelete").hasRole("ADMIN")
                .antMatchers("/report/all","/report/add","/report/edit").hasAnyRole("USER", "ADMIN")
                .antMatchers("/report/delete","/report/askForDelete").hasRole("ADMIN")
                .antMatchers("/owner/all").hasAnyRole("USER", "ADMIN")
                .antMatchers("/owner/add","/owner/edit","/owner/delete","/owner/askForDelete").hasRole("ADMIN")
                .antMatchers("/serviceman/all").hasAnyRole("USER", "ADMIN")
                .antMatchers("/serviceman/add","/serviceman/edit","/serviceman/delete","/serviceman/askForDelete").hasRole("ADMIN")
                .anyRequest().authenticated().and().csrf().disable().formLogin().loginPage("/login")
                .defaultSuccessUrl("/home")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
