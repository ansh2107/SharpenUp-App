package sharpenup.previous.sharpenup;

import sharpenup.previous.sharpenup.DataHolderClass;

public class DataHolderClass {
private static DataHolderClass dataObject = null;

private DataHolderClass() {
    // left blank intentionally
}

public static DataHolderClass getInstance() {
    if (dataObject == null)
        dataObject = new DataHolderClass();
    return dataObject;
}
private String distributor_id;;

 public String getDistributor_id() {
    return distributor_id;
 }

 public void setDistributor_id(String distributor_id) {
    this.distributor_id = distributor_id;
 }
}