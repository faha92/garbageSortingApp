package dk.itu.garbage;


import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;



public class ItemsDB<r> {
    private static ItemsDB sItemsDB;
    public final HashMap<String, String> GarbageMap = new HashMap<>();
    private ItemsDB(Context context) { fillItemsDB(context,"items.txt"); }

    public ItemsDB() {
    }

    public static void initialize(Context context) {
        if (sItemsDB == null) sItemsDB= new ItemsDB(context);
    }

    public static ItemsDB get() {
        if (sItemsDB == null) throw new IllegalStateException("ItemsDB must be initialized");
        return sItemsDB;
    }

    public HashMap<String, String> getItemsDB() {return GarbageMap; }

    public String listItems() {
        String r= "";
        for (HashMap.Entry <String, String> item: GarbageMap.entrySet())
            r= r+"\n Buy "+item.getKey() + " in: "  + item.getValue();
        return r;
    }

    public int size() { return GarbageMap.size(); }

    public void addItem(String what, String where){

        GarbageMap.put(what, where);
    }

    public void removeItem(String what){
        if (GarbageMap.get(what) != null)  GarbageMap.remove(what);
    }
    public void fillItemsDB(Context context, String filename) {
        try {
            BufferedReader reader= new BufferedReader(
                    new InputStreamReader(context.getAssets().open(filename)));
            String line= reader.readLine();
            while (line != null) {
                String[] gItem= line.split(",");
                GarbageMap.put(gItem[0], gItem[1]);
                line= reader.readLine();
            }
        } catch (IOException e) {  // Error occurred when opening raw file for reading.
        }
    }

    public String garbageLookup(String what) {

        return what + " should be placed in: " + GarbageMap.get(what); }


}




