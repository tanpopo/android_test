package mytest.list;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

import mytest.list.MyStock;
import mytest.list.StockAdapter;

public class ListViewTestActivity extends Activity {
    /** Called when the activity is first created. */

	private ListView stockListView;

	  // ListViewに表示するデータ
	private ArrayList<MyStock> stockList = new ArrayList<MyStock>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        stockListView = (ListView)this.findViewById(R.id.stockListView);

        // イベントハンドラを設定
        stockListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 選択されたデータを取得
            ListView listView = (ListView)parent;
            MyStock stock = (MyStock)listView.getItemAtPosition(position);

            showInfoDialog(stock);
          } //onItemClick()
        });//onCsetOnItemClickListener()

        //adapter
//        StockAdapter<MyStock> adapter = new StockAdapter<MyStock>(//コンパイルエラーになる！！
//    	      this,
//    	      R.layout.row_stock, // 1行分のレイアウトファイル
//    	      R.id.stockView,  // 上記レイアウト内のテキスト表示箇所のId
//    	      stockList             // 表示対象のデータ
//    	      );
      StockAdapter adapter = new StockAdapter(
	      this,
	      R.layout.row_stock, // 1行分のレイアウトファイル
	      R.id.stockView,  // 上記レイアウト内のテキスト表示箇所のId
	      stockList             // 表示対象のデータ
	      );

        stockListView.setAdapter(adapter);
    	    // ListViewに表示するデータを作成
        stockList.add(new MyStock(1, "Yahoo"));
        stockList.add(new MyStock(2, "Google"));
        stockList.add(new MyStock(3, "Amazon"));
    }//onCreate()

    private void showInfoDialog(MyStock stock) {
	 // 選択されたデータをダイアログで表示
	    AlertDialog.Builder dialog = new AlertDialog.Builder(ListViewTestActivity.this);
	    dialog.setTitle("あなたの選んだ本");
	    dialog.setMessage("ID:" + stock.getId() + "\nName:" + stock.getName());
	    dialog.show();
    }

}

