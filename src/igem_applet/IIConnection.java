package igem_applet;import java.sql.Connection;public class IIConnection {    public IIConnection() {    }	public static Connection getIIConnection(){		try{			Class.forName("com.mysql.jdbc.Driver");		}catch(Exception e){			e.printStackTrace();		}finally{		}		MysqlTunnelSession session = new MysqlTunnelSession("dayhoff.ii.metu.edu.tr", 22, "****", "********" ,"127.0.0.1", 3306,"****", "***********"); // password information replaced with *****		Connection con = session.getConnection("sasandb");		return con;	}}