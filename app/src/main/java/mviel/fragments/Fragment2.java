package mviel.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Fragment2 extends Fragment {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private int cuentaClicks = 0;


    private OnFragmentInteractionListener2 mListener;


    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment2, container, false);

        FrameLayout fl = (FrameLayout) v.findViewById(R.id.FrameLayout1);

        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment3 miFragment3 = new Fragment3();
                cuentaClicks +=1;
                Bundle args = new Bundle();
                args.putInt("cuentaClicks", cuentaClicks);
                miFragment3.setArguments(args);

                fm = getFragmentManager();
                ft = fm.beginTransaction();
                //si
                if (!mListener.estaFragment3EnActivity()) {
                    Toast.makeText(getActivity(), "Mostrant Fragment3", Toast.LENGTH_SHORT).show();
                    ft.add(R.id.canto_inferior_dret, miFragment3);
                    ft.addToBackStack("atras");

                }else{

                    Toast.makeText(getActivity(), "Amagant Fragment3", Toast.LENGTH_SHORT).show();
                    ft.remove(getFragmentManager().findFragmentById(R.id.canto_inferior_dret));//con esto eliminamos el fragment necesario
                    ft.addToBackStack("atras");
                }
                ft.commit();
            }
    });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction2(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener2) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener2 {
        // TODO: Update argument type and name
         void onFragmentInteraction2(Uri uri);
         boolean estaFragment3EnActivity();
    }



}
