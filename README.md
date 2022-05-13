# Koin Debug

## Issue

When injecting a class in another, here a viewModel, the argument is taken after the module instance.

## Classes

```
class InjectedClass 
```

```
class MainActivityViewModel(
    val injectedClass: InjectedClass
) : ViewModel()
```

## Snippet

#### Declaration

```
startKoin {
    androidContext(this@App)
}

loadKoinModules(
    module {
        singleOf(::InjectedClass)
        viewModelOf(::MainActivityViewModel)
    }
)
```

#### Get

```
private val injectedClass: InjectedClass = InjectedClass()

private val viewModel by viewModel<MainActivityViewModel> {
    parametersOf(injectedClass)
}

// Here injectedClass instance is not the same as viewModel.injectedClass
```
