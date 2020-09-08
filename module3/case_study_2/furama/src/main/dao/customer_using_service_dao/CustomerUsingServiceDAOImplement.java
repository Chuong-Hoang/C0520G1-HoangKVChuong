package main.dao.customer_using_service_dao;

import main.common.DBConnection;
import main.model.customer_model.Customer;
import main.model.customer_using_service_model.CustomerUsingService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingServiceDAOImplement implements CustomerUsingServiceDAO {
    /* ....................... Table and Column ......................*/

    private static final String COL_NAME_1 = "customer_id";
    private static final String COL_NAME_2 = "customer_name";
    private static final String COL_NAME_3 = "contract_id";
    private static final String COL_NAME_4 = "contract_detail_id";
    private static final String COL_NAME_5 = "service_id";
    private static final String COL_NAME_6 = "service_name";
    private static final String COL_NAME_7 = "attach_service_id";
    private static final String COL_NAME_8 = "attach_service_name";

    private static final String cm = ",";
    private static final String eq = " = ?";
    /* .......................... Table end .........................*/

    private static final String SELECT_CUSTOMER_USING_SERVICE = "select customer.customer_id, customer.customer_name, " +
            "contract.contract_id, contract_detail.contract_detail_id,\n" +
            "\tcontract.service_id, service.service_name, attach_service.attach_service_id, " +
            "attach_service.attach_service_name\n" +
            "from `customer`\n" +
            "inner join `contract` on contract.customer_id = customer.customer_id\n" +
            "left join `service` on contract.service_id = service.service_id\n" +
            "left join `contract_detail` on contract.contract_id = contract_detail.contract_id\n" +
            "left join `attach_service` on contract_detail.attach_service_id = attach_service.attach_service_id;";
//<%--        //        this.customerId = customerId;--%>
//<%--        //        this.customerName = customerName;--%>
//<%--        //        this.contractId = contractId;--%>
//<%--        //        this.contractDetailId = contractDetailId;--%>
//<%--        //        this.serviceId = serviceId;--%>
//<%--        //        this.serviceName = serviceName;--%>
//<%--        //        this.attachServiceId = attachServiceId;--%>
//<%--        //        this.attachServiceName = attachServiceName;--%>

    @Override
    public List<CustomerUsingService> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<CustomerUsingService> eList = new ArrayList<>();
        CustomerUsingService el = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_USING_SERVICE);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new CustomerUsingService();
                    el.setCustomerId(resultSet.getString(COL_NAME_1));
                    el.setCustomerName(resultSet.getString(COL_NAME_2));
                    el.setContractId(String.valueOf(resultSet.getInt(COL_NAME_3)));
                    el.setContractDetailId(String.valueOf(resultSet.getString(COL_NAME_4)));
                    el.setServiceId(resultSet.getString(COL_NAME_5));
                    el.setServiceName(resultSet.getString(COL_NAME_6));
                    el.setAttachServiceId(String.valueOf(resultSet.getString(COL_NAME_7)));
                    el.setAttachServiceName(resultSet.getString(COL_NAME_8));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eList;
    }
}
