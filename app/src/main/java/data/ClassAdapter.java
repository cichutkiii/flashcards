package data;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import pl.preclaw.fiche.R;

public class ClassAdapter  extends RecyclerView.Adapter<ClassListHolder> {
    private List<ClassItem> classList = new ArrayList<>();
    private List<String> classIds = new ArrayList<>();
    private Context mContext;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;
    private  static final String TAG = "classList";


    public ClassAdapter(final Context context, DatabaseReference reference) {
        mContext = context;
        mDatabaseReference = reference;

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                // A new comment has been added, add it to the displayed list
                ClassItem classItem = dataSnapshot.getValue(ClassItem.class);

                classIds.add(dataSnapshot.getKey());
                classList.add(classItem);
                notifyItemInserted(classList.size() - 1);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                ClassItem newClassItem = dataSnapshot.getValue(ClassItem.class);


                String commentKey = dataSnapshot.getKey();

                // [START_EXCLUDE]
                int commentIndex = classIds.indexOf(commentKey);
                if (commentIndex > -1) {
                    // Replace with the new data
                    classList.set(commentIndex, newClassItem);

                    // Update the RecyclerView
                    notifyItemChanged(commentIndex);
                } else {
                    Log.w(TAG, "onChildChanged:unknown_child:" + commentKey);
                }
                // [END_EXCLUDE]
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String commentKey = dataSnapshot.getKey();

                // [START_EXCLUDE]
                int commentIndex = classIds.indexOf(commentKey);
                if (commentIndex > -1) {
                    // Remove data from the list
                    classIds.remove(commentIndex);
                    classList.remove(commentIndex);

                    // Update the RecyclerView
                    notifyItemRemoved(commentIndex);
                } else {
                    Log.w(TAG, "onChildRemoved:unknown_child:" + commentKey);
                }
                // [END_EXCLUDE]
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                ClassItem movedClassItem = dataSnapshot.getValue(ClassItem.class);
                String commentKey = dataSnapshot.getKey();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
                Toast.makeText(mContext, "Failed to load comments.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        reference.addChildEventListener(childEventListener);
        // [END child_event_listener_recycler]

        // Store reference to listener so it can be removed on app stop
        mChildEventListener = childEventListener;
    }


    @Override
    public ClassListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.class_list_rv_item, parent, false);
        return new ClassListHolder(view);
    }

    @Override
    public void onBindViewHolder(ClassListHolder holder, int position) {
        ClassItem subject = classList.get(position);
        holder.className.setText(subject.name);
        holder.classDescr.setText(subject.descr);
        holder.classClasses.setText(subject.classes);
        holder.classLanguage.setText(subject.language);
        holder.classLink.setText(subject.ondata);


    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    public void cleanupListener() {
        if (mChildEventListener != null) {
            mDatabaseReference.removeEventListener(mChildEventListener);
        }
    }

    public ClassItem getTitles(int position) {
        return(null != classList ? classList.get(position) : null);
    }
}

