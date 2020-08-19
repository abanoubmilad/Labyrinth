<p align="center">
  <img src="labyrinth.png" width="400" alt="accessibility text">
</p>

<h1 align="center">
Labyrinth 
</h1>

<h2 align="center">
A multi stack android navigation</h2>


```Groovy

allprojects {
    repositories {

        maven { url "https://jitpack.io" }
        
    }
}
```

Add  dependency inside app level `build.gradle`

```Groovy
    dependencies {

        implementation 'com.github.abanoubmilad:labyrinth:0.1'
        
    }
```

```kotlin
class ExampleMultiNavActivity : AppCompatActivity(), INavHolder {

    lateinit var labyrinth: Labyrinth
    override fun getINav() = labyrinth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_multi_nav_activity)

        labyrinth = Labyrinth.Builder(
            viewModelStoreOwner = this,
            lifecycleOwner = this,
            fragmentManager = supportFragmentManager,

            fragmentContainerId = R.id.nav_host_container,
            bottomNavigationView = bottom_nav,

            rootTabFragmentsInitializer = listOf(
                { Welcome() },
                { Leaderboard() },
                { Register() }
            ),
            menuItemIdToRootTabFragmentIndexMap = hashMapOf(
                R.id.home to 0,
                R.id.list to 1,
                R.id.form to 2

            )).apply {
            defaultSelectedTabIndex = 1
            saveStateEnabled = true
            resetOnSameTabClickEnabled = false

        }.build()
    }


    override fun onDestroy() {
        labyrinth.onDestroy()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (labyrinth.shouldCallSuperOnBackPressed())
            super.onBackPressed()
    }

}

```    

```kotlin
class About1 : BaseFragment() {
    override val layoutId = R.layout.fragment_about1

    override fun onCreated() {
    }


    override fun onVisible() {
    }

}
```