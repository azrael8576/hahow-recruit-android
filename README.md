#### 這是一個基於MVVM架構+Jetpack的最佳實踐，UI 項目復刻 Hahow 面試 ios 工程師小專案

## Project Documentation

    ├─ adapters
    ├─ data
    ├─ utilities
    ├─ viewmodels
    ├─ workers
    | Application
    | Activity
    | Fragment

* `adapters/*.*` : Adapter for the [RecyclerView]
* `data/*.*` : App資料來源 e.g. AppDatabase, DataClass, DAO, Repository相關類
* `utilities/InjectorUtils.kt` : Static methods used to inject classes needed for various Activities and Fragments.
* `utilities/*.*` : App公用類 e.g. app常數, Utils相關類
* `viewmodels/*.*` : ViewModel, ViewModelFactory.
* `workers/*.*` : WorkManager, CoroutineWorker.

## 設計概念

* 採 MVVM Design Pattern, 所有業務邏輯皆撰寫於 ViewModel 中, 透過 ViewModelFactory 提供 ViewModel類.
* 從伺服器端提取課程(local json file模擬)後會儲存於 Local Storage 中
* 開啟畫面由 LoginActivity 模擬登入 or 驗證身分頁

### Third Party Library 

* ViewModel : ViewModel From Jetpack
* LiveData : LiveData From Jetpack
* Navigation : Fragment 切換相關操作
* Room ：本地資料庫
* Stetho ：Database Inspection(資料庫檢查) 開發調適工具
* Gson ：解析 JSON 資料格式
* kotlin-android-extensions ：提供 Parcelize 注釋
* navigation.safeargs ：Fragment 間資料傳遞

## 備註
#### 平板畫面未實作：由於本人電腦系統有問題，無法開啟模擬器。僅用實機開發手機畫面
#### Data Binding 未做導入：本人習慣僅用 View Binding 開發


### 畫面呈現

#### SAMSUNG GALAXY Note 5
![image](https://github.com/azrael8576/hahow-recruit-android/blob/master/hahow-recruit-android.gif)

## 原需求文件
[Hahow 應徵 ios 工程師小專案](https://github.com/azrael8576/hahow-recruit-android/blob/master/HahowSourceDoc.MD "Hahow應徵ios工程師小專案")
