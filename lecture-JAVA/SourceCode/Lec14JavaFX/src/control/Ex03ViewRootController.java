package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import control.model.Camera;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ex03ViewRootController implements Initializable {
	
	@FXML ListView<String> listView;
	@FXML TableView<Camera> tableView; 
	@FXML ImageView imageView;
	
	@FXML TableColumn<Camera, String> tcMaker;
	@FXML TableColumn<Camera, String> tcImage;
	@FXML TableColumn<Camera, Integer> tcPrice;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	// *** UI 컨트롤 초괴화, 이벤트 해냐들링 등록, 속성 감시 및 바인딩 ***

		// ! ListView Item set
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add("Nikon");
		itemList.add("Canon");
		itemList.add("Sony");
		
		listView.getItems().addAll(itemList);
		
		// ! TableView Item set
		tableView.setItems(FXCollections.observableArrayList(
					new Camera("Nikon", "Nikon.png", 1200000),
					new Camera("Canon", "Canon.png", 1300000),
					new Camera("Sony", "Sony.png", 1400000)
				));
		
		// ! 테이블 컬럼에 CellValueFactory를 설정
		tcMaker.setCellValueFactory(new PropertyValueFactory<Camera, String>("maker")); // maker의 정보를 뿌려줘라
		tcImage.setCellValueFactory(new PropertyValueFactory<Camera, String>("image"));
		tcPrice.setCellValueFactory(new PropertyValueFactory<Camera, Integer>("price"));
		
		// ! 속성 감시
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				System.out.println("선택된 인덱스: " + newValue); // ; 확인용
				
				tableView.getSelectionModel().select(newValue.intValue()); // ; index로 검색해서 가져오기
				tableView.scrollTo(newValue.intValue()); // ; 스크롤 이동
				
			}
		});
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Camera>() {
			@Override
			public void changed(ObservableValue<? extends Camera> observable, Camera oldValue, Camera newValue) {
				
				System.out.println("선택된 Item(maker): " + newValue.getMaker()); // ; 확인용
				
				imageView.setImage(new Image("/res/images/" + newValue.getImage()));
				
				
			}
		});
	
	}	
	
	public void handleOk(ActionEvent event) {
		
		String item = listView.getSelectionModel().getSelectedItem();
		System.out.println("선택된 리스트 아이템 : " + item);
		
		Camera camera = tableView.getSelectionModel().getSelectedItem();
		if(camera != null) {
			System.out.println("PRODUCTOR: " + camera.getMaker());
			System.out.println("PRICE: " + camera.getPrice());
		}
		
	}

	public void handleCancel(ActionEvent event) {
		Platform.exit();
	}
	
}
