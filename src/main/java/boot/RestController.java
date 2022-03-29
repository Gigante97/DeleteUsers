package boot;

import db.ConnectDb;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public static class RestResponse {
        private String status;
        private String phone;


        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod(String phone) {
        RestResponse result = new RestResponse();
        try {
            ConnectDb db = new ConnectDb();
            db.connectSql();
            if (db.checkExistPhone(phone)==false){
                db.disconnectSql();
                result.setStatus("Номер не найден");
                result.setPhone(phone);
            } else {
                db.setBlockime(phone);
                db.deleteSession(phone);
                db.disconnectSql();
                result.setStatus("удалили");
                result.setPhone(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result.setStatus("ошибка сервера");
            result.setPhone(phone);
        }
        return result;
    }

}
