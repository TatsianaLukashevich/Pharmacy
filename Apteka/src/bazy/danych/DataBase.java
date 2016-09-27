package bazy.danych;

import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.pool.OracleDataSource;

public class DataBase 
{
	private Connection conn;
	
	public DataBase() throws SQLException
	{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:tlukashe/tlukashe@ora3.elka.pw.edu.pl:1521:ora3inf");
		conn = ods.getConnection();
		conn.setAutoCommit(false);
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println("JDBC driver version is " + meta.getDriverVersion());
	}
	public void sampleInsertExecution(ArrayList<String> list) throws SQLException
	{
		PreparedStatement insert = null;
		String insertString = "INSERT INTO APTEKA VALUES(?,?,?)";
		Savepoint sp = conn.setSavepoint();
		
		try
		{
			insert = conn.prepareStatement(insertString);
			insert.setInt(1, Integer.parseInt(list.get(0)));
			insert.setInt(2, Integer.parseInt(list.get(1)));
			//insert.setString(2, list.get(1));
			insert.setString(3, list.get(2));
			insert.executeUpdate();
			
		}
	
		
		
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Transaction is being rolled back");
			conn.rollback(sp);
		}
		finally
		{
			conn.commit();
			insert.close();
		}
	}
	
	public void sampleUpdateExecution(ArrayList<String> list) throws SQLException
	{
		PreparedStatement insert = null;
		String insertString = "UPDATE APTEKA SET ID_SZPITAL=? WHERE NUMER=?";
		Savepoint sp = conn.setSavepoint();
		
		try
		{
			insert = conn.prepareStatement(insertString);
			insert.setInt(1, Integer.parseInt(list.get(0)));
			insert.setInt(2, Integer.parseInt(list.get(1)));
			insert.executeUpdate();
			
		}
	
		
		
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Transaction is being rolled back");
			conn.rollback(sp);
		}
		finally
		{
			conn.commit();
			insert.close();
		}
	}
	
	public void sampleDeleteExecution(ArrayList<String> list) throws SQLException
	{
		PreparedStatement insert = null;
		String insertString = "DELETE FROM APTEKA WHERE NUMER > ?";
		Savepoint sp = conn.setSavepoint();
		
		try
		{
			insert = conn.prepareStatement(insertString);
			insert.setInt(1, Integer.parseInt(list.get(0)));
			insert.executeUpdate();
			
		}
	
		
		
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Transaction is being rolled back");
			conn.rollback(sp);
		}
		finally
		{
			conn.commit();
			insert.close();
		}
	}
	
	public void sampleSelectExecution() throws SQLException
	{
		Statement stmt = null;
		StringBuilder temp = new StringBuilder();
		String selectString = "SELECT * FROM APTEKA JOIN SZPITAL ON APTEKA.ID_SZPITAL=SZPITAL.ID" ;
		Savepoint sp = conn.setSavepoint();
		
		try
		{
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(selectString);
			while (rset.next())
			{
				int a = rset.getInt(1);
				int b = rset.getInt(2);
				String c = rset.getString(3);
				
				temp.append(a + "/" + b + "/" + c + "/"  + "\n");
				
			}	
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Transaction is being rolled back");
			conn.rollback(sp);
		}
		finally
		{
			conn.commit();
			System.out.println(temp.toString());
		}
	}
	
	public void sampleGroupExecution() throws SQLException
	{
		Statement stmt = null;
		StringBuilder temp = new StringBuilder();
		String selectString = "SELECT ADRES FROM APTEKA GROUP BY ADRES " ;
		Savepoint sp = conn.setSavepoint();
		
		try
		{
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(selectString);
			while (rset.next())
			{
				//int a = rset.getInt(1);
				//int b = rset.getInt(2);
				String c = rset.getString(1);
				
				temp.append(/*a + "/" + b + "/" + */c + "/"  + "\n");
				
			}	
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Transaction is being rolled back");
			conn.rollback(sp);
		}
		finally
		{
			conn.commit();
			System.out.println(temp.toString());
		}
	}
	
	public void sampleOrderExecution() throws SQLException
	{
		Statement stmt = null;
		StringBuilder temp = new StringBuilder();
		String selectString = "SELECT ADRES FROM SZPITAL ORDER BY ADRES " ;
		Savepoint sp = conn.setSavepoint();
		
		try
		{
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(selectString);
			while (rset.next())
			{
				//int a = rset.getInt(1);
				//int b = rset.getInt(2);
				String c = rset.getString(1);
				
				temp.append(/*a + "/" + b + "/" + */c + "/"  + "\n");
				
			}	
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Transaction is being rolled back");
			conn.rollback(sp);
		}
		finally
		{
			conn.commit();
			System.out.println(temp.toString());
		}
	}
	
	/*public void sampledropExecution() throws SQLException
	{
		Statement stmt = null;
		StringBuilder temp = new StringBuilder();
		String selectString = "DROP TRIGGER wstaw; " ;
		Savepoint sp = conn.setSavepoint();
		
		try
		{
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(selectString);
			while (rset.next())
			{
				//int a = rset.getInt(1);
				//int b = rset.getInt(2);
				//String c = rset.getString(1);
				
				//temp.append(/*a + "/" + b + "/" + *//*c + "/"  + "\n");
				
			}	
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Transaction is being rolled back");
			conn.rollback(sp);
		}
		finally
		{
			conn.commit();
			System.out.println(temp.toString());
		}
	}*/
	
}
