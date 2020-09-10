package main.dao.amount_dao;

import main.common.DBConnection;
import main.model.amount_model.Amount;
import main.model.customer_using_service_model.CustomerUsingService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmountDAOImplement implements AmountDAO {
    /* ....................... Table and Column ......................*/

    private static final String COL_NAME_1 = "customer_id";
    private static final String COL_NAME_2 = "customer_name";
    private static final String COL_NAME_3 = "contract_id";

    private static final String COL_NAME_4 = "service_id";
    private static final String COL_NAME_5 = "service_name";
    private static final String COL_NAME_6 = "contract_total_money";
    private static final String COL_NAME_7 = "attach_service_total_money";


    private static final String cm = ",";
    private static final String eq = " = ?";
    /* .......................... Table end .........................*/

    private static final String SELECT_CUSTOMER_USING_SERVICE = "select customer.customer_id, customer.customer_name, contract.contract_id,\n" +
            "\tcontract.service_id, service.service_name, \n" +
            "    contract.contract_total_money, sum(attach_service.attach_service_cost * contract_detail.quantity) as `attach_service_total_money`\n" +
            "from `customer`\n" +
            "\tinner join `contract` on contract.customer_id = customer.customer_id\n" +
            "\tleft join `service` on contract.service_id = service.service_id\n" +
            "\tleft join `contract_detail` on contract.contract_id = contract_detail.contract_id\n" +
            "\tleft join `attach_service` on contract_detail.attach_service_id = attach_service.attach_service_id\n" +
            "group by customer.customer_id;";


    @Override
    public List<Amount> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Amount> eList = new ArrayList<>();
        Amount el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_USING_SERVICE);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Amount();
                    el.setCustomerId(resultSet.getString(COL_NAME_1));
                    el.setCustomerName(resultSet.getString(COL_NAME_2));
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_3)));
                    el.setServiceId(resultSet.getString(COL_NAME_4));
                    el.setServiceName(resultSet.getString(COL_NAME_5));
                    el.setContractTotalMoney(String.valueOf(resultSet.getDouble(COL_NAME_6)));
                    el.setAttachServiceTotalMoney(String.valueOf(resultSet.getDouble(COL_NAME_7)));


                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eList;
    }
}
