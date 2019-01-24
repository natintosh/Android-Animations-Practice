import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

inline fun FragmentManager.addToStackInTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().addToBackStack(null).commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun AppCompatActivity.addFragmentToStack(fragment: Fragment, frameId: Int) {
    supportFragmentManager.addToStackInTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragmentToStack(fragment: Fragment, frameId: Int) {
    supportFragmentManager.addToStackInTransaction { replace(frameId, fragment) }
}