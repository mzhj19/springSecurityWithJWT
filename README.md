
# Spring Security along with using JWT

A Full implementation of Spring Security using Json Web Token.


 
 
#### configuration Class:
    The configuration class sets up the necessary components for authentication and     security using JWT. It defines beans for user details service, authentication provider, authentication manager, and password encoder. These beans can be used by other parts of the application for handling user authentication and security operations.

#### @Configuration: 
    This annotation indicates that the class is a configuration class and contains bean definitions.

#### @RequiredArgsConstructor: 
    This annotation is from Lombok library and generates a constructor with required arguments for the class. In this case, it injects the UserRepository dependency.

#### UserDetailsService userDetailsService(): 
    This method defines a bean for the UserDetailsService interface. It retrieves user details based on the provided username. It uses the UserRepository to find a user by email and throws a UsernameNotFoundException if the user is not found.

#### AuthenticationProvider authenticationProvider(): 
    This method defines a bean for the AuthenticationProvider interface. It creates an instance of DaoAuthenticationProvider, sets the UserDetailsService and PasswordEncoder dependencies, and returns the configured authentication provider. This provider is responsible for authenticating users based on the provided credentials.

#### AuthenticationManager authenticationManager: 
    This method defines a bean for the AuthenticationManager interface. It retrieves the authentication manager from the AuthenticationConfiguration object and returns it. The authentication manager is used for authenticating requests.

#### PasswordEncoder passwordEncoder(): 
    This method defines a bean for the PasswordEncoder interface. It creates and returns an instance of BCryptPasswordEncoder, which is a commonly used password encoder that uses the bcrypt hashing algorithm.

#### OncePerRequestFilter: 
    This class is a base class provided by Spring that ensures the filter is only executed once per request.

#### doFilterInternal(): 
    This method is the main logic of the filter that performs the JWT authentication. It overrides the doFilterInternal() method from the base class.

#### authHeader and jwt: 
    These variables store the Authorization header and the JWT token extracted from it.

#### SecurityFilterChain securityFilterChain(HttpSecurity http): 
    This method defines a bean for the SecurityFilterChain. It configures the security filters and their order for incoming requests.

#### csrf().disable(): 
    This disables CSRF (Cross-Site Request Forgery) protection for the application.

#### .authorizeHttpRequests(): 
    This starts the configuration for request authorization rules.

#### .requestMatchers("/api/v1/auth/**").permitAll(): 
    This allows unauthenticated access (permit all) to the endpoints matching the "/api/v1/auth/**" pattern. These endpoints are commonly used for authentication-related operations.

#### .anyRequest().authenticated(): 
    This requires authentication for any other requests that do not match the previous rule. It ensures that any request not explicitly permitted requires authentication.

#### .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS): 
    This configures the session management to be stateless, meaning no session will be created or used for authentication. JWT-based authentication does not rely on server-side sessions.

#### .authenticationProvider(authenticationProvider): 
    This sets the custom authentication provider (AuthenticationProvider) that was defined in the previous code snippet.

#### .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class): 
    This adds the custom JwtAuthenticationFilter before the default UsernamePasswordAuthenticationFilter. It ensures that the JWT authentication filter is applied before the standard form-based authentication filter.

#### http.build(): 
    This builds and returns the configured SecurityFilterChain.
    
