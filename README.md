# hahow-recruit-android
復刻 Hahow 面試 ios 小專案 by MVVM架構


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

* 採 MVVM Design Pattern, 所有業務邏輯皆撰寫於 ViewModel 中, 再透過 ViewModelFactory 提供 ViewModel類.
* 從伺服器端提取(local json file模擬)課程後會儲存於 Local Storage 中
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


### 畫面呈現

#### SAMSUNG GALAXY Note 5
![image](https://github.com/azrael8576/hahow-recruit-android/blob/master/hahow-recruit-android.gif)



# Hahow iOS Engineer 面試小專案

請使用 Swift 和 UIKit 實作一個 app 首頁課程列表畫面，並寫文件或註解來解釋你的設計考量。除了指定需求外，你可以自由設計 model 和 UI 來提供更好的體驗。

## 技術規定
- Deployment Target 為 iOS 13.0。
- 請使用 Swift 和 UIKit 開發。
- 需同時支援 iPhone 和 iPad。
- 可使用第三方 library。
- 可使用 Cocoapods, Carthage, SPM 或任何第三方管理工具。
- 請寫文件或註解來解釋你的設計考量。

## 需求
請實作一個在 app 首頁看到的課程列表，需求如下：

#### 資料
- 請設計一個的 Data Loader 的抽象層來提供課程資料。
- 請用專案中提供的 json file 實作上述 Data Loader 的一個實例。

#### UI 設計
- 課程依照其類別分為若干群組。
- 在 iPhone 上，每個類別顯示三堂課程，其中第一堂課的設計樣式為大圖，其餘為小圖。
- 在 iPad 上，每個類別顯示四堂課程，且每堂課程都使用小圖樣式。課程排列為一行兩堂課程，由左至右、上至下 Z 字型排列。
- iPhone 只需要支援 portrait 豎直方向，iPad 需要全方向 & 分割畫面。
- 課程標題至多兩行，課程講師至多一行（大圖小圖規則相同）。
- 提示
  - 本題目不用在意卡片尺寸、顏色、間距等細節，請將重點放在如何排版。（你仍然可以盡量符合示意圖）
  - 你可以用 table view、collection view 或任何你熟悉的方式實作。

iPhone 畫面示意 | iPad 畫面示意
--- | ---
![iPhone](https://user-images.githubusercontent.com/4545214/135952573-3db78035-4ddc-4760-8974-89006cbbb608.png) | ![iPad](https://user-images.githubusercontent.com/4545214/135956833-1ede9bcc-f269-47d3-8485-6c493cee8d9c.png)

## 交卷

- 請下載或 fork Hahow iOS Engineer 面試題目初始專案（[repo 在此](https://github.com/hahow/iOS-recruit-project)）。
- 請將成果上傳至 GitHub 並直接提供 repo 連結。
