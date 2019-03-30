package com.example.styleout15.FirstAppAccess;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.DataBase.Vestito;
import com.example.styleout15.FirstAppAccess.Down.Down;
import com.example.styleout15.FirstAppAccess.Down.DownRecyclerAdapter;
import com.example.styleout15.R;

import java.util.ArrayList;
import java.util.List;

public class DownFragment extends Fragment {

    View dView;
    private RecyclerView myRecyclerViewDown;
    private List<Down> lstDown;
    private ImageView downImageView;
    private ImageButton button;
    private Vestito vestito;
    private DBAdapterLogin db;

    public static final String[] titles = new String[] {
            "apricot", "ashGray", "azure", "beige", "black", "blue", "bluegray", "bluejeans",
            "bottlegreen", "celeste", "coral", "darkGreen", "gold", "gray", "green",
            "greenblue", "lavender", "lightblue", "magenta", "midnightblue", "mintgreen",
            "navyblue", "oceanBlue", "oceanGreen", "olive", "orange", "pink", "red", "rose",
            "sand", "scarlet", "silver", "tangerine", "turquoise", "violet", "white", "yellow"};

    public static final String[]hexcodes = {
            "#FACEB1", "#B4BFB7", "#0080FF", "#F5F5DC", "#000000", "#0000FF", "#6699CC", "#5CAEED", "#006B4F",
            "#B2FFFF", "#FF7E4F", "#013321", "#A67F00", "#808080", "#008000", "#1065B5", "#E6E6FA", "#ACD7E5", "#D1417F", "#191970", "#3EB589",
            "#1975D1", "#4F41B5", "#49BF92", "#808000", "#FF6600", "#FFBFCA", "#C40233", "#FF0080", "#C2B180", "#FF2200",
            "#BFBFBF", "#F28500", "#41E0D0", "#8702B0", "#FFFFFF", "#FFD400"};

    public static final Integer[] images = {
            R.drawable.apricot, R.drawable.ashgray, R.drawable.azure, R.drawable.beige,
            R.drawable.black, R.drawable.blue, R.drawable.bluegray, R.drawable.bluejeans,
            R.drawable.bottlegreen, R.drawable.celeste, R.drawable.coral, R.drawable.darkgreen,
            R.drawable.gold, R.drawable.gray, R.drawable.green, R.drawable.greenblue,
            R.drawable.lavender, R.drawable.lightblue, R.drawable.magenta, R.drawable.midnightblue,
            R.drawable.mintgreen, R.drawable.navyblue, R.drawable.oceanblue, R.drawable.oceangreen,
            R.drawable.olive, R.drawable.orange, R.drawable.pink, R.drawable.red,
            R.drawable.rose, R.drawable.sand, R.drawable.scarlet, R.drawable.silver,
            R.drawable.tangerine, R.drawable.turquoise, R.drawable.violet, R.drawable.white,
            R.drawable.yellow};

    Spinner spinner;
    List<RowItem> rowItems;

    Spinner fabricSelect;

    public DownFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        dView = inflater.inflate(R.layout.down_fragment, container, false);

        button = dView.findViewById(R.id.downButtonAdd);
        db = new DBAdapterLogin(dView.getContext());

        downImageView = dView.findViewById(R.id.imagechange_down);

        vestito = new Vestito();
        vestito.setNome("Vestito");
        vestito.setDisponibile(1);

        final View imageChangeTop = dView.findViewById( R.id.imagechange_down );

        myRecyclerViewDown = (RecyclerView) dView.findViewById(R.id.down_recyclerview);
        DownRecyclerAdapter recyclerViewAdapter = new DownRecyclerAdapter(getContext(), lstDown);
        myRecyclerViewDown.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerViewDown.setAdapter(recyclerViewAdapter);

        myRecyclerViewDown.addOnItemTouchListener( new com.example.styleout14.PrimoAccesso.RecyclerItemClickListener( getContext(),
                myRecyclerViewDown, new com.example.styleout14.PrimoAccesso.RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText( view.getContext(), ""+position, Toast.LENGTH_SHORT).show();
                vestito.setTipoVestito(Integer.toString(201 + position));
                vestito.setPic_tag(lstDown.get(position).getModelDownImage());
                downImageView.setImageResource(lstDown.get(position).getModelDownImage());
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        } ) );

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem( images[i], titles[i] );
            rowItems.add( item );
        }

        spinner = (Spinner) dView.findViewById(R.id.downspinner);
        ColourSelectorAdapter adapter = new ColourSelectorAdapter( getActivity(),
                R.layout.colour_spinner, R.id.color, rowItems);
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemvalue = parent.getItemAtPosition( position ).toString();
                vestito.setColore(itemvalue);
                vestito.setColorCode(hexcodes[position]);
                downImageView.setBackgroundColor( Color.parseColor(hexcodes[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        fabricSelect = (Spinner) dView.findViewById(R.id.fabricdownselect);
        List<String> list = new ArrayList<>();
        // lightweight fabrics
        list.add("Cotton"); list.add("Silk");
        // mesh fabrics
        list.add("Cape"); list.add("Lace"); list.add("Tarlatan");
        // medium weight fabrics
        list.add("Cashmere"); list.add("Crepe");list.add("Flannel"); list.add("Poplin"); list.add("RawSilk"); list.add("Sateen");
        // piled fabrics
        list.add("BrushDenim");list.add("Fur"); list.add("Microfiber"); list.add("Suede"); list.add("Velvet");
        // heavy weight fabrics
        list.add("Canvas"); list.add("Denim"); list.add("Tartan"); list.add("Upholstery");
        // Shiny glossy fabrics
        list.add("Satin"); list.add("Silk"); list.add("PolishedCotton");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fabricSelect.setAdapter(adapter1);
        fabricSelect.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addVestito(vestito.getColore(), vestito.getColorCode(), vestito.isDisponibile(),
                        vestito.getNome(), "cotone", Integer.parseInt(vestito.getTipoVestito()), vestito.getPic_tag(), 0);
                Toast.makeText(dView.getContext(), "vestito aggiunto", Toast.LENGTH_SHORT).show();
            }
        });

        return dView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        lstDown = new ArrayList<>();
        lstDown.add( new Down( R.drawable.trousers ));
        lstDown.add( new Down( R.drawable.trousers_one ));
        lstDown.add( new Down( R.drawable.trousers_two ));
        lstDown.add( new Down( R.drawable.trousers_three ));
        lstDown.add( new Down( R.drawable.trousers_four ));
        lstDown.add( new Down( R.drawable.trousers_five ));
        lstDown.add( new Down( R.drawable.skirt ));
        lstDown.add( new Down( R.drawable.skirt_one ));
        lstDown.add( new Down( R.drawable.skirt_two ));
    }
}
