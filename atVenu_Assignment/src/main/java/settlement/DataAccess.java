/* Author: Brett Dawson
 * This class establishes a connection with the MySQL (MariaDB) database hosted locally on port 3306. It also retrieves
 * product information based on a passed in ID value. The update() method would function, but I didn't manage to get it
 * working with the HTML form's POST submission.
 */
package settlement;

import model.Unit;
import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccess {
    // This method establishes a connection with the database I prepared for demo purposes.
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/atvenu", "brett", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    // This method would have been able to execute a POST operation that updates the given product record in the database.
    public static int update(Unit id){
        int status = 0;
        try{
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE `units` SET `Units_Sold`=?,`Unit_Price`=?," +
                    "`Prod_Desc`=?,`Total_Sales`=?,`Qty_Avail`=? WHERE `Prod_Id`=?");
            ps.setInt(1, id.getUnitsSold());
            ps.setString(2, id.getUnitPrice().toString());
            ps.setString(3, id.getProdDesc());
            ps.setString(4, id.getTotalSales().toString());
            ps.setInt(5, id.getQtyAvail());
            ps.setInt(6, id.getId());
            status=ps.executeUpdate();
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    // The below method gets a record from the units table in the atVenu database based on the product Id.
    public static Unit getProductById(int id){
        Unit u=null;
        try{
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM units WHERE Prod_Id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                u=new Unit();
                u.setId(rs.getInt("Prod_Id"));
                u.setUnitsSold(rs.getInt("Units_Sold"));
                u.setUnitPrice(rs.getBigDecimal("Unit_Price"));
                u.setProdDesc(rs.getString("Prod_Desc"));
                u.setTotalSales(rs.getBigDecimal("Total_Sales"));
                u.setQtyAvail(rs.getInt("Qty_Avail"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }
}
