package DbTestPackage;
import java.sql.*;

public class MemberService {
    public void dbSelect() {
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. password
        // 5. instance

        String url = "jdbc:mariadb://192.168.154.128:3306/testdb6";
        String dbUserId = "testuser6";
        String dbPassword = "zerobase";

        // DB에 접속하기 위한 STEP 6
        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook

        String memberTypeValue = "email";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 커넥션 객체 생성

            String sql = " select  member_type, user_id, password, name " +
                    " from member2 " +
                    " where member_type = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);

            rs = preparedStatement.executeQuery();

            while(rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void dbInsert(Member member) {

        String url = "jdbc:mariadb://192.168.154.128:3306/testdb6";
        String dbUserId = "testuser6";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 커넥션 객체 생성

            String sql = " insert into member2 (member_type, user_id, password, name) " +
                    " values (?, ?, ?, ?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getName());

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void dbUpdate() {

        String url = "jdbc:mariadb://192.168.154.128:3306/testdb6";
        String dbUserId = "testuser6";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 커넥션 객체 생성

            String sql = " update member2 set " +
                    " password = ? " +
                    " where member_type = ? and user_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void dbDelete() {

        String url = "jdbc:mariadb://192.168.154.128:3306/testdb6";
        String dbUserId = "testuser6";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 커넥션 객체 생성

            String sql = " delete from member2 " +
                    "where member_type = ? and user_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);
            preparedStatement.setString(2, userIdValue);

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 삭제 성공 ");
            } else {
                System.out.println(" 삭제 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
