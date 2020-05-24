package inputdata;

import java.io.IOException;

public class DataSetter {
    private final String username;
    private final String password;
    private final String uRL;;

    ExcelReader excelReader = new ExcelReader("/home/pun/Work/aut/inputData", "InputData.xlsx", "stage");

    public DataSetter() throws IOException {
        this.uRL = excelReader.readRow(0);
        this.username = excelReader.readRow(1);
        this.password = excelReader.readRow(2);

    }


    public String getuRL() {return uRL;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
