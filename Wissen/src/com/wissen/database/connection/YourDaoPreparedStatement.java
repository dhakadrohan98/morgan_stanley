package com.wissen.database.connection;

/*
 * public class YourDaoPreparedStatement {
 * 
 * 	@Autowired
 *	private DataSource dataSource;
 *
 *	private static final String ACTIVE_FEED_ID_SQL = 
        "SELECT feedId FROM stars_staging.StagedFeedVersion WHERE feedTypeId = ? AND valid = true AND" 
        + "active = true";
        
    public void executeQuery() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ACTIVE_FEED_ID_SQL)) {
             
            preparedStatement.setInt(1, FeedType.AMMReports.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int feedId = resultSet.getInt("feedId");
                System.out.println("Feed ID: " + feedId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 *
 * }
 */
