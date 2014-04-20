package edu.vt.vthacks.outclass;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.parse.Parse;
import android.app.Activity;
import android.os.Bundle;

public class ScheduledGroupActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_scheduled_group_layout);
        setUpListView();
    }

    public void getDetails(View view) {
        Intent intent = new Intent(this, ViewDetails.class);
        ListView textView = (ListView) findViewById(R.id.viewScheduledGroups_listView);
        startActivity(intent);
    }

    private void setUpListView() {
        ListView list = (ListView) findViewById(R.id.viewScheduledGroups_listView);
        final ArrayAdapter<GroupDetail> groupAdapter = new GroupAdapter(this);
        groupAdapter.add(new GroupDetail("Demo Name", "Demo Class"));
        list.setAdapter(groupAdapter);
        list.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroupDetail groupDetail = groupAdapter.getItem(position);

                Intent i = new Intent(getApplicationContext(), ViewDetails.class);
                i.putExtra("info", groupDetail);
                startActivity(i);
            }
        });
    }

    public void info(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Group Info").setMessage("TEST HERE").show();
    }

    private class GroupAdapter extends ArrayAdapter<GroupDetail> {
        private static final int LAYOUT = R.layout.two_line_list_item;

        public GroupAdapter(Context context) {
            super(context, LAYOUT);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(LAYOUT, parent, false);
            GroupDetail officeHours = getItem(position);

            TextView name = (TextView)row.findViewById(R.id.two_line_list_item_title);
            name.setText(officeHours.getName());

            TextView theClass = (TextView)row.findViewById(R.id.two_line_list_item_subtitle);
            theClass.setText(officeHours.getTheClass());

            return row;
        }
    }
}