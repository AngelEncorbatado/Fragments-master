package mviel.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment1 extends Fragment {
    private RelativeLayout layoutF1;
    private FragmentManager mifragmentManager;
    private FragmentTransaction miFragTransaction;
    private Fragment2 fragment_miFragment2;
    private MainActivity miMain;
    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        layoutF1 = (RelativeLayout) v.findViewById(R.id.layoutF1);

        layoutF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Has fet click en Fragment1",Toast.LENGTH_SHORT).show();
                fragment_miFragment2 = new Fragment2();
                mifragmentManager = getFragmentManager();
                miFragTransaction = mifragmentManager.beginTransaction();
                miFragTransaction.replace(R.id.canto_superior_dret,fragment_miFragment2,"");
                miFragTransaction.addToBackStack("atras");
                miFragTransaction.commit();
            }
        });
        layoutF1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(getActivity(),"Hiciste Long Click en el fragment 1",Toast.LENGTH_SHORT).show();
                    mifragmentManager = getFragmentManager();
                    miFragTransaction = mifragmentManager.beginTransaction();
            Fragment2 f2 = (Fragment2)mifragmentManager.findFragmentById(R.id.canto_superior_dret);//como ya tenemos obtenido el fragment manager buscamos con findFragmentByid el fragment que nos interesa

                if(f2 != null) {
                    miFragTransaction.remove(f2);//Eliminamos el fragment si existe
                }
            Fragment3 f3 = (Fragment3)mifragmentManager.findFragmentById(R.id.canto_inferior_dret);//Obtenemos el fragment manager y entonces buscamos el fragment
                if(f3 != null){
                    miFragTransaction.remove(f3);//Eliminamos el fragment si existe
                }

                         miFragTransaction.addToBackStack("atras"); //para que se desaga el conjunto de las operaciones realizadas en el onLongClick lo agregamos al final
                         miFragTransaction.commit();
                return true;//al devolver true en el evento onLongClick decimos que el evento ya ha terminado, si fuera false seguiria escuchando los Click basicos
            }
        });
        return v;
    }

}
