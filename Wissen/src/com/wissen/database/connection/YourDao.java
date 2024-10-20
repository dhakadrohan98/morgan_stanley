package com.wissen.database.connection;

/*
 * public class YourDao {
 * 		private final JdbcTemplate jdbcTemplate;
 * 
 * 		public YourDao(JdbcTemplate jdbcTemplate) {
        	this.jdbcTemplate = jdbcTemplate;
    	}
    	
    	private static final String ACTIVE_FEED_ID_SQL = 
        	"SELECT feedId FROM stars_staging.StagedFeedVersion WHERE feedTypeId = ? AND" +
        	"valid = true AND active = true";
        	
        public List<Integer> getActiveFeeds() {
        	jdbcTemplate.query(ACTIVE_FEED_ID_SQL, new Object[]{FeedType.AMMReports.getId()},
        	(rs, rowNum) -> rs.getInt("feedId"));
        }
 * }
 */
