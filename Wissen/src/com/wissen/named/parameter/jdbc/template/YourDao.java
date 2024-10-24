package com.wissen.named.parameter.jdbc.template;

/*
 * public class YourDao {
 * 
 *    static {
	    activeFeedIdSql = "SELECT feedId FROM stars_staging.StagedFeedVersion WHERE feedTypeId = :feedTypeId AND valid = true AND active = true";
	  }
 * 
	 * private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 * 
	 * public YourDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	 * 		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate; 
	 * }
	 * 
	 * public List<Integer> getActiveFeedIds() { 
		 * MapSqlParameterSource params = new MapSqlParameterSource(); 
		 * params.addValue("feedTypeId", FeedType.AMMReports.getId());
		 * 
		 * return namedParameterJdbcTemplate.query(activeFeedIdSql, params, new MyEntityRowMapper());
	 * 
	 * } 
 * }
 */
