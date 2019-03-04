package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

	/**
	 * ログインIDとパスワードに紐づくユーザ情報を返す
	 * @param loginId
	 * @param password
	 * @return
	 */
	public User findByLoginInfo(String loginId, String password) {
		Connection conn = null;


		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			String loginpassword= cood(password);
			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, loginpassword);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	/**
	 * 全てのユーザ情報を取得する
	 * @return
	 */
	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user where id!=1";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;

	}

	public void UserNewInfo(String loginId, String password, String username, String birthday) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "insert into user (login_id,name,birth_date,password,create_date,update_date) values(?,?,?,?,now(),now())";

			String Newpassword= cood(password);
			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, username);
			pStmt.setString(3, birthday);
			pStmt.setString(4, Newpassword);
			pStmt.executeUpdate();
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}



	public User UserDetalist(String id) {

		Connection conn = null;
		try {

			// データベースへ接続
			conn = DBManager.getConnection();
			String sql= "SELECT * FROM user where login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			//1回だけという公式
			if(!rs.next()) {
				return null;}
			//
			int id1 = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			return new User(id1, loginId, name, birthDate, password, createDate, updateDate);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public void UserInformationInfo(String name,String password,String birth_date,String id){

		Connection conn = null;
		try {

			// データベースへ接続
			conn = DBManager.getConnection();

			if(!password.equals("")) {
				String sql= "UPDATE user SET name = ?,birth_date = ?,password = ?,update_date = now() where login_id=?;";
				String Infomationpassword= cood(password);

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, name);
				pStmt.setString(2, birth_date);
				pStmt.setString(3, Infomationpassword);
				pStmt.setString(4, id);
				pStmt.executeUpdate();
			}
			else{
				String sql= "UPDATE user SET name = ?,birth_date = ?,update_date = now() where login_id=?;";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, name);
				pStmt.setString(2, birth_date);
				pStmt.setString(3, id);
				pStmt.executeUpdate();
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			return ;
		} finally {



			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}
	public void DeleteInfo(String loginId) {

		Connection conn = null;
		try {

			// データベースへ接続
			conn = DBManager.getConnection();


			String sql = "DELETE FROM user WHERE login_id IN (?)";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);

			pStmt.executeUpdate();
			pStmt.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}


	public List<User> UserListInfo(String loginId, String username, String birth_date,String birth_date1){

		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user WHERE id!=1";

			if(!loginId.equals("")){
				sql += " AND login_id = '" + loginId + "'";
			}

			if(!username.equals("")){
				sql += " AND name LIKE '%" + username + "%'";
			}
			if(!birth_date.equals("")){
				sql += " AND birth_date >= '" + birth_date + "'";
			}
			if(!birth_date1.equals("")){
				sql += " AND birth_date <='" + birth_date1 + "'";
			}

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String login_id= rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password1 = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, login_id, name, birthDate, password1, createDate, updateDate);

				userList.add(user);
			}


		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}


	public String cood(String password){




	//ハッシュを生成したい元の文字列
	String source = password;
	//ハッシュ生成前にバイト配列に置き換える際のCharset
	Charset charset = StandardCharsets.UTF_8;
	//ハッシュアルゴリズム
	String algorithm = "MD5";

	//ハッシュ生成処理
	byte[] bytes=null;
	try {
	bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
	}catch(NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	String result = DatatypeConverter.printHexBinary(bytes);
	return result;
	}
}