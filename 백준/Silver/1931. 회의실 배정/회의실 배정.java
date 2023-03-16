import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	 static class MeetingRoom implements Comparable<MeetingRoom> {
		int start;
		int end;

		public MeetingRoom(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "MeetingRoom [start=" + start + ", end=" + end + "]";
		}

		// 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
		// 회의의 시작시간과 끝나는 시간이 같을 수도 있다.
		@Override
		public int compareTo(MeetingRoom o) {
			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 1;
		List<MeetingRoom> timeTable = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			timeTable.add(new MeetingRoom(start, end));
		}
		Collections.sort(timeTable, (a, b) -> a.start - b.start);
		Collections.sort(timeTable);
		
		int selectedEnd = timeTable.get(0).end;
		for (int i = 1; i < timeTable.size(); i++) {
			if (timeTable.get(i).start >= selectedEnd) {
				selectedEnd = timeTable.get(i).end;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
