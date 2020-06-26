package com.atenea.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UsuarioRepositoryAuthProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// PAGINAS PUBLICAS
		http.authorizeRequests().antMatchers("/index.html").permitAll();
		http.authorizeRequests().antMatchers("/login.html").permitAll();
//		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/classes.html").permitAll();
		http.authorizeRequests().antMatchers("/blog.html").permitAll();
		http.authorizeRequests().antMatchers("/blog_single.html").permitAll();
		http.authorizeRequests().antMatchers("/register.html").permitAll();
		http.authorizeRequests().antMatchers("/calendario.html").permitAll();
		http.authorizeRequests().antMatchers("/pricing.html").permitAll();
		http.authorizeRequests().antMatchers("/single_class.html").permitAll();
		http.authorizeRequests().antMatchers("/about.html").permitAll();


		//http.authorizeRequests().antMatchers("/logout").permitAll();

		

		// PAGINAS PRIVADAS
		http.authorizeRequests().antMatchers("/planpersonalizado.html").hasAnyRole("CLIENTE");

		 http.authorizeRequests().antMatchers("/").hasAnyRole("USER");
		
		// Login form
		http.formLogin().loginPage("/login.html");
		http.formLogin().usernameParameter("email");
		http.formLogin().passwordParameter("pass");
		http.formLogin().defaultSuccessUrl("/index.html");
//		http.formLogin().failureUrl("/loginerror");
		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/login");

		// Disable CSRF at the moment
		http.csrf().disable();
	}

	
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	  
//	  // User
//	  auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
//	  
//	  //Database authentication provider
//	  auth.authenticationProvider(authenticationProvider); 
//	  }
	 
	
}


