package com.example.nativetest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nabinbhandari.android.permissions.PermissionHandler;

import java.io.File;
import java.util.ArrayList;

public class ListSongFromStorage extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("taglib");
    }

    ListView listView_songs;
    private String listofSongs[];
    boolean permisstion_granted=false;
    JNIInteract jniInteract;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listingsongfromstorage);
        listView_songs=findViewById(R.id.listview_songs_id);
        ask_permission();
        if(permisstion_granted)
        {
            final ArrayList<File> listoffiles=getalistofsongs(Environment.getExternalStorageDirectory());
            listofSongs=new String[listoffiles.size()];
            for(int i=0; i<listoffiles.size(); i++){
                String name=listoffiles.get(i).getName();
                name.replace(".mp3","");
                listofSongs[i]=name;
            }

            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,listofSongs);
            listView_songs.setAdapter(arrayAdapter);

            listView_songs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //fetching the song name user clicked
                    String name=listofSongs[position];
                    jniInteract.passingDataToJni(name);

                    Audiofileproperties audiofileproperties=new Audiofileproperties();
                    String title=audiofileproperties.getTitle();
                    Intent intent=new Intent(ListSongFromStorage.this,ShowMeTags.class);
                    intent.putExtra("title",title);
                    startActivity(intent);
                }
            });
        }
    }

    private ArrayList<File> getalistofsongs(File rootDirectory) {
        ArrayList<File> listoffiles=new ArrayList<>();
        File file[]=rootDirectory.listFiles();

        for(File f:file){
            if(f==null) continue;
            if(f.isDirectory())
                listoffiles.addAll(getalistofsongs(f));
            else if(f.getName().endsWith(".mp3")) {
                listoffiles.add(f);
            }
        }
        return listoffiles;
    }

    //Handling permissions
    private void ask_permission() {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        final String rationale = "Provide Storage permission so that we can fetch all audios.No privacy will be breached";
        com.nabinbhandari.android.permissions.Permissions.check(this/*context*/, permissions, rationale, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                permisstion_granted=true;
            }

            @Override
            public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                Toast.makeText(ListSongFromStorage.this,rationale,Toast.LENGTH_LONG).show();
                ask_permission();
            }
        });
    }

}