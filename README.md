# JavaFirstProject
第一個JAVA作業 <br>
製作登錄系統可購買飲料與會員管理 <br>

<hr>

## [Dump20240610](/Dump20240610)
此地為資料庫檔案 <br>
會員資料與購買紀錄 <br>
schema：blueblue <br>
[連線檔](/src/dao/DbConnection.java) <br>
user = "root"; <br>
password = "1234"; <br>

### 會員
會員在最後一個欄位level來做區分<br>
* A：員工
* B：白金會員
* C：一般會員

初次註冊的皆為一般會員，需藉由員工帳號來修改等級 <br>
一般與白金會員接只能修改個人資料，員工帳號才能修改全體人員之帳號 <br>

## [src](/src)
存放程式碼資料夾
### controller
UI介面
### dao
連接資料庫方法
### img
照片檔
### model
物件
1. Drink
   ``` java
	  private int idbrink; // 不顯示
	  private String username;
	  private String name;
	  private int peach; // 密桃奶茶 60
	  private int melon; // 冷露歐雷 65
	  private int brown; // 黑糖鮮奶 75
   ```
2. People
   ``` java
	  private Integer idpeople;
	  private String username;
	  private String password;
	  private String name;
	  private String address1;
	  private String address2;
	  private String birthday;
	  private String tel;
	  private String level;
   ```
### util
會使用到的函數方法，目前只有存取文件檔相關函數

