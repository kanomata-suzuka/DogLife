package Service;

import Model.Schedule;
import Util.InputUtil;

public class ScheduleManagement {

	private Schedule[] schedules = new Schedule[100];
	private int count = 0;

	// 登録
	public void addSchedule() {

		System.out.println();
		System.out.println("===== 予定登録 =====");

		String dogName = InputUtil.inputString("犬の名前：");
		String title = InputUtil.inputString("予定名：");
		String date = InputUtil.inputString("予定日：");
		String detail = InputUtil.inputString("詳細：");

		schedules[count] = new Schedule(
				dogName,
				title,
				date,
				detail);

		count++;

		System.out.println("予定を登録しました。");
	}

	// 一覧表示
	public void displaySchedules() {

		System.out.println();
		System.out.println("===== 予定一覧 =====");

		if (count == 0) {
			System.out.println("登録されている予定はありません。");
			return;
		}

		for (int i = 0; i < count; i++) {

			System.out.println("No." + (i + 1));
			System.out.println("犬の名前：" + schedules[i].getDogName());
			System.out.println("予定名：" + schedules[i].getTitle());
			System.out.println("予定日：" + schedules[i].getDate());
			System.out.println("詳細：" + schedules[i].getDetail());
			System.out.println("--------------------");
		}
	}

	// 更新
	public void updateSchedule() {

		System.out.println();
		System.out.println("===== 予定更新 =====");

		if (count == 0) {
			System.out.println("登録されている予定はありません。");
			return;
		}

		displaySchedules();

		int number = InputUtil.inputInt("更新する予定のNo.：");

		if (number < 1 || number > count) {
			System.out.println("正しいNo.を入力してください。");
			return;
		}

		int index = number - 1;

		String dogName = InputUtil.inputString("犬の名前：");
		String title = InputUtil.inputString("予定名：");
		String date = InputUtil.inputString("予定日：");
		String detail = InputUtil.inputString("詳細：");

		schedules[index].setDogName(dogName);
		schedules[index].setTitle(title);
		schedules[index].setDate(date);
		schedules[index].setDetail(detail);

		System.out.println("予定を更新しました。");
	}

	// 削除
	public void deleteSchedule() {

		System.out.println();
		System.out.println("===== 予定削除 =====");

		if (count == 0) {
			System.out.println("登録されている予定はありません。");
			return;
		}

		displaySchedules();

		int number = InputUtil.inputInt("削除する予定のNo.：");

		if (number < 1 || number > count) {
			System.out.println("正しいNo.を入力してください。");
			return;
		}

		int index = number - 1;

		for (int i = index; i < count - 1; i++) {
			schedules[i] = schedules[i + 1];
		}

		schedules[count - 1] = null;
		count--;

		System.out.println("予定を削除しました。");
	}

	// 検索
	public void searchSchedule() {

		System.out.println();
		System.out.println("===== 予定検索 =====");

		String keyword = InputUtil.inputString("検索する予定名：");

		boolean found = false;

		for (int i = 0; i < count; i++) {

			if (schedules[i].getTitle().contains(keyword)) {

				System.out.println("--------------------");
				System.out.println("犬の名前：" + schedules[i].getDogName());
				System.out.println("予定名：" + schedules[i].getTitle());
				System.out.println("予定日：" + schedules[i].getDate());
				System.out.println("詳細：" + schedules[i].getDetail());

				found = true;
			}
		}

		if (!found) {
			System.out.println("該当する予定がありません。");
		}
	}
}