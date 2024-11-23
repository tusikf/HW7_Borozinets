import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.layout.R
import com.example.layout.R.layout.my_first_custom_view


class MyFirstTryCustomView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    init {
        inflate(context, my_first_custom_view, this)
    }
}
