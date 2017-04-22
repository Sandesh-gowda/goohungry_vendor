package com.goohungrry.ecode.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.goohungrry.ecode.R;
import com.goohungrry.ecode.responce.MenuItem;

import java.util.ArrayList;

/**
 * Created by linuxy on 1/24/17.
 */

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuHolder> {

    private final LayoutInflater mInflater;
    private ArrayList<MenuItem> mMenuList;
    private Context mcontext;


    public MenuListAdapter(ArrayList<MenuItem> mMenuList, Context mcontext) {
        this.mMenuList = mMenuList;
        this.mcontext = mcontext;
        mInflater = LayoutInflater.from(mcontext);

    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.menu_item_layout, parent, false);
        return new MenuHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        final MenuItem model = mMenuList.get(position);
        holder.cost.setText("₹" + model.menu_price);
        holder.foodTitle.setText(model.menu_name);
        holder.foodDescription.setText(model.menu_desc);


        Uri imageUri = Uri.parse(model.menu_url);
        holder.foodImage.setImageURI(imageUri);
//        holder.counter.setText(String.valueOf(model.count));

        // String veg = "res:/" + R.drawable.ic_veg;
        //  String nonVeg = "res:/" + R.drawable.ic_veg ;
        Uri nonveg = Uri.parse("http://52.66.31.77/lobo/banners/ic_non_veg.png");
        Uri veg = Uri.parse("http://52.66.31.77/lobo/banners/ic_veg.png");
        String type = model.type;

        if (type.equals("0")) {

            holder.foodType.setImageURI(nonveg);
        } else {
            holder.foodType.setImageURI(veg); // veg
        }


        // onclick listener

//        holder.setClickListener(new RecyclerView_OnClickListener.OnClickListener() {
//            @Override
//            public void OnItemClick(View view, int position) {
//                String str;
//                switch (view.getId()) {
//                    case R.id.ivSubtractProduct:
//                        Util.initToast(mcontext, "subract");
//                        if (model.count > 0) {
//                            model.count--;
//                            notifyDataSetChanged();
//                            int total = 0;
//                            int count = 0;
//                            for (MenuList menu : mMenuList) {
//                                if (menu.count > 0) {
//                                    total = total + (menu.count * Integer.parseInt(menu.getMenu_price()));
//                                    count = count + menu.count;
//                                }
//                            }
//
//
//                            for (MenuList m : mMenuList) {
//
//                                if (m.count > 0) {
//
//
//                                    Log.v("List_lessbutton:", m.count + ":" + m.getApi_key() + ":" + m.getMenu_name() + ":");
//                                    str = Integer.toString(m.count);
//                                    //put add call here .
//                                    addCall(m.getId(), str, m.getMenu_price());
//
//
//                                }
//                            }
//
//                            Snackbar snackbar = Snackbar.make(view, count + "\t|\t₹" + String.valueOf(total), Snackbar.LENGTH_SHORT);
//                            View snacbar = snackbar.getView();
//                            TextView snac_tx = (TextView) snacbar.findViewById(android.support.design.R.id.snackbar_text);
//                            // TextView snac_tx = (TextView) snacbar.findViewById(android.support.design.R.id.snackbar_text);
//                            snac_tx.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_mto, 0, 0, 0);
//
//                            snackbar.setAction("Proceed", new View.OnClickListener() {
//
//                                @Override
//                                public void onClick(View v) {
//                                    //This will take to list of item in the shopping cart.
//                                    //   Toast.makeText(context, "Moving to next activity were cart activity", Toast.LENGTH_SHORT).show();
//
//
//                                    //   this is where the code of array list will go shopping cart
//
//                                    Intent intent = new Intent(mcontext, UserBasket.class);
//                                    mcontext.startActivity(intent);
//
//                                }
//                            });
//
//                            snac_tx.setGravity(Gravity.CENTER);
//                            snackbar.show();
//
//                        }
//
//
//                        break;
//                    case R.id.ivAddProduct:
//                        Util.initToast(mcontext, "Add");
//
//
//                        model.count++;
//                        notifyDataSetChanged();
//                        int total = 0;
//                        int count = 0;
//                        for (MenuList menu : mMenuList) {
//                            if (menu.count > 0) {
//                                total = total + (menu.count * Integer.parseInt(menu.getMenu_price()));
//                                count = count + menu.count;
//                            }
//                        }
//
//
//                        // code to check  hariprasad
//
//                        for (MenuList m : mMenuList) {
//
//                            if (m.count > 0) {
//                                Log.v("List:", m.count + ":" + m.getApi_key() + ":" + m.getMenu_name() + ":");
//                                str = Integer.toString(m.count);
//                                //put add call here
//                                addCall(m.getId(), str, m.getMenu_price());
//                            }
//                        }
//                        Snackbar snackbar = Snackbar.make(view, count + "\t|\t₹" + String.valueOf(total) + ".00\t", Snackbar.LENGTH_LONG);
//                        View snacbar = snackbar.getView();
//                        TextView snac_tx = (TextView) snacbar.findViewById(android.support.design.R.id.snackbar_text);
//                        snac_tx.setCompoundDrawablesWithIntrinsicBounds(R.drawable.eat_now, 0, 0, 0);
//                        snackbar.setAction("Proceed", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                //This will take to list of item in the shopping cart.
//                                //    Toast.makeText(context, "Moving to next activity were cart activity", Toast.LENGTH_SHORT).show();
//
//
//                                Intent intent = new Intent(mcontext, UserBasket.class);
//                                mcontext.startActivity(intent);
//
//
//                                // Intent intent = new Intent(context, UserCart.class);
//                                //  context.startActivity(intent);
//                            }
//                        });
//                        snac_tx.setGravity(Gravity.CENTER);
//                        snackbar.show();
////                            Toast.makeText(context,"Plus Clicked",Toast.LENGTH_LONG).show();
//
//
//                        ///code ends
//
//
//                        break;
//                }
//            }
//        });


    }

//    private void addCall(final String id, final String str, final String menu_price) {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://52.66.31.77/lobo/v1/bookingreq",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.v("ASS", response.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("menuid", id);
//                map.put("qty", str);
//                map.put("cost", menu_price);
//                map.put("userid", Myapp.getInstance().getPrefManager("Login_Preferences").getUser().getOthid());
//                map.put("name", "user");
//                map.put("mobile", "9988776655");
//
//                return map;
//            }
//        };
//        Myapp.getInstance().getRequestQueue().add(stringRequest);
//    }

    @Override
    public int getItemCount() {
        return (null != mMenuList ? mMenuList.size() : 0);
    }


    public class MenuHolder extends RecyclerView.ViewHolder {


        public TextView cost; //tvPriceProductConsise
        public ImageView subtract;//ivSubtractProduct
        public ImageView add;//tvCurrentQuantity
        public TextView counter;//ivAddProduct//

        public SimpleDraweeView foodType; //iv_foodTypeProductConcise , veg or nonveg
        public TextView foodTitle; //tv_product_title_productCoincise
        public TextView foodDescription; //tv_product_discription_productConcise
        public SimpleDraweeView foodImage;  //product_image

        public MenuHolder(View itemView) {
            super(itemView);

            cost = (TextView) itemView.findViewById(R.id.tvPriceProductConsise);
            foodType = (SimpleDraweeView) itemView.findViewById(R.id.iv_foodTypeProductConcise);
            foodTitle = (TextView) itemView.findViewById(R.id.tv_product_title_productCoincise);
            foodDescription = (TextView) itemView.findViewById(R.id.tv_product_discription_productConcise);
            foodImage = (SimpleDraweeView) itemView.findViewById(R.id.product_image);

            subtract = (ImageView) itemView.findViewById(R.id.ivSubtractProduct);
            add = (ImageView) itemView.findViewById(R.id.ivAddProduct);
            counter = (TextView) itemView.findViewById(R.id.tvCurrentQuantity);

        }


    }


}
