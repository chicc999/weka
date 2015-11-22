
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import com.njust.edu.lyx.wdbc.dal.dataObject.Record;
import com.njust.edu.lyx.wdbc.dal.dataProvider.Daos;
import com.njust.edu.lyx.wdbc.model.DecisionTree;

public class Main {

    private static final List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
    private static final List<String> attributeList = new ArrayList<String>();
    
    public static void main(String args[]){
        
        DecisionTree dt = new DecisionTree();
        
        Daos daos =null;
		try {
			daos = Daos.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(Record record:daos.getTrainList())
        {
        	dataList.add(record.getAttribute());
        }
        
       // attributeList.add("id");
        attributeList.add("meanTexture");
        attributeList.add("worstArea");
        attributeList.add("worstSmoothness");
        
        TreeNode node = (TreeNode) dt.createDT(dataList,attributeList);
        System.out.println();
    }
}