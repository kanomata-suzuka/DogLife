package Service;

import java.util.ArrayList;

import Model.Schedule;
import Util.InputUtil;

public class ScheduleManagement {

	private ArrayList<Schedule> schedules = new ArrayList<>();

	// 登録
	public void addSchedule() {

		System.out.println();
		System.out.println("===== 予定登録 =====");

		String dogName = InputUtil.inputString("犬の名前：");
		String title = InputUtil.inputString("予定名：");
		String date = InputUtil.inputString("予定日：");
		String detail = InputUtil.inputString("詳細：");

		Schedule schedule = new Schedule(dogName, title, date, detail);

		schedules.add(schedule);

		System.out.println("予定を登録しました。");
	}

	// 一覧表示
	public void displaySchedules() {

		System.out.println();
		System.out.println("===== 予定一覧 =====");

		if (schedules.isEmpty()) {

			System.out.println("登録されている予定はありません。");
			return;
		}

		for (int i = 0; i < schedules.size(); i++) {

			Schedule schedule = schedules.get(i);

			System.out.println("No." + (i + 1));
			System.out.println("犬の名前：" + schedule.getDogName());
			System.out.println("予定名：" + schedule.getTitle());
			System.out.println("予定日：" + schedule.getDate());
			System.out.println("詳細：" + schedule.getDetail());
			System.out.println("--------------------");
		}
	}

	// 更新
	public void updateSchedule() {

		System.out.println();
		System.out.println("===== 予定更新 =====");

		if (schedules.isEmpty()) {

			System.out.println("登録されている予定はありません。");
			return;
		}

		displaySchedules();

		int number = InputUtil.inputInt("更新する予定のNo.：");

		// 入力チェック
		if (number < 1 || number > schedules.size()) {

			System.out.println("正しいNo.を入力してください。");
			return;
		}

		int index = number - 1;

		Schedule schedule = schedules.get(index);

		String dogName = InputUtil.inputString("犬の名前：");

		String title = InputUtil.inputString("予定名：");

		String date = InputUtil.inputString("予定日：");

		String detail = InputUtil.inputString("詳細：");

		schedule.setDogName(dogName);
		schedule.setTitle(title);
		schedule.setDate(date);
		schedule.setDetail(detail);

		System.out.println("予定を更新しました。");
	}

	// 削除
	public void deleteSchedule() {

		System.out.println();
		System.out.println("===== 予定削除 =====");

		if (schedules.isEmpty()) {

			System.out.println("登録されている予定はありません。");
			return;
		}

		displaySchedules();

		int number = InputUtil.inputInt("削除する予定のNo.：");

		// 入力チェック
		if (number < 1 || number > schedules.size()) {

			System.out.println("正しいNo.を入力してください。");
			return;
		}

		int index = number - 1;

		schedules.remove(index);

		System.out.println("予定を削除しました。");
	}

	// 検索
	public void searchSchedule() {

		System.out.println();
		System.out.println("===== 予定検索 =====");

		String keyword = InputUtil.inputString("検索する予定名：");

		boolean found = false;

		for (Schedule schedule : schedules) {

			if (schedule.getTitle().contains(keyword)) {

				System.out.println("--------------------");
				System.out.println("犬の名前：" + schedule.getDogName());
				System.out.println("予定名：" + schedule.getTitle());
				System.out.println("予定日：" + schedule.getDate());
				System.out.println("詳細：" + schedule.getDetail());

				found = true;
			}
		}

		if (!found) {

			System.out.println("該当する予定がありません。");
		}
	}
}