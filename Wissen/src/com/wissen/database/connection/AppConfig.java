package com.wissen.database.connection;

// Manually create and configure Jdbc Template:

/*
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.jdbc.datasource.DriverManagerDataSource;
 * import javax.sql.DataSource;
 * 
 * @Configuration
 * public class CreateManuallyConfigureJdbcTemplate {
 *  
 *  	@Bean
 *  	public DataSource dataSource() {
 *  		DriverManagerDataSource dataSouce = new DriverManagerDataSource();
 *  		dataSouce.setDriverClassName("com.mysql.cj.jdbc.Driver");
 *  		dataSource.setUrl("jdbc:mysql://localhost:3306/your_database");
 *  		dataSource.setUsername("admin");
	        dataSource.setPassword("admin");
	        return dataSource;
 *  	}
 *  
 *  	@Bean
 * 		public JdbcTemplate jdbcTemplate() {
 * 			return new JdbcTemplate(DataSource dataSource);
 * 		} 
 * 
 * 		@Bean
	    public YourDao yourDao(JdbcTemplate jdbcTemplate) {
	        return new YourDao(jdbcTemplate);
	    }
	    
 * }
 */
