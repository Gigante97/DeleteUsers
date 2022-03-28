package boot;

import db.ConnectDb;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public static class RestResponse {
        private String p1;
        private String p2;


        public String getP2() {
            return p2;
        }

        public void setP2(String p2) {
            this.p2 = p2;
        }

        public String getP1() {
            return p1;
        }

        public void setP1(String p1) {
            this.p1 = p1;
        }

    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod(String phone) throws SQLException {
        RestResponse result = new RestResponse();
        ConnectDb db = new ConnectDb();
        db.connectSql();
        db.setBlockime(phone);
        db.deleteSession(phone);
        db.disconnectSql();
        result.setP1("удален");
        result.setP2(phone);


        return result;
    }

}
