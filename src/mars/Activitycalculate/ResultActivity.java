package mars.Activitycalculate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private TextView result_dis;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        result_dis = (TextView)findViewById(R.id.result_view); 
        Intent intent = getIntent();
        String factor_str1 = intent.getStringExtra("factor1");
        String factor_str2 = intent.getStringExtra("factor2");
        //java�н��ַ���ת�����������﷨
        int factor_int1 = Integer.parseInt(factor_str1);
        int factor_int2 = Integer.parseInt(factor_str2);
        int result = factor_int1 * factor_int2;
        //java������ֻҪ2��������һ��Ϊ�ַ��ͣ�����Զ�����һ��Ҳת�����ַ���
        result_dis.setText(result + "");
        
    }

    
//   @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_result, menu);
//        return true;
//    }
}











