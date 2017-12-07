package zsk.newIdea;

public class ShuDuDemo {
	
	public static void main(String[] args){
		ShuduMainFrame mainFrame = new ShuduMainFrame();
		mainFrame.setVisible(true);
	}
	private static int[][] maps = new int[9][9];

	private static int[] canPutSum = new int[9];
	static int[] used = new int[9];
	static boolean isOk = true;

	/*
	 * �õ�������ͼ����
	 */
	public static int[][] getMap() {

		do{
			isOk = true;
			initMaps();
		}while(!isOk);
		return maps;
	}

	/*
	 * ��ʼ��maps
	 */
	private static void initMaps() {
		// ��ʼ����ͼ������û�������κ�����
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				maps[i][j] = -1;
			}
		}

		// ��������1~9
		for (int num = 1; num <= 9; num++) {
			for (int i = 0; i < 9; i++) {
				used[i] = -1;
				canPutSum[i] = -1;
			}
			// ������Ź����е�ÿ��С�Ź���
			for (int i = 0; i < 9; i++) {
				if (canPutSum[i]==-1) {
					canPutSum[i] = getCanPutSum(i, num);
				}
				if (canPutSum[i]==1) {
					used[i] = -1;
				}
				
				if (canPutSum[i] == 0) {
					canPutSum[i] = -1;
					used[i] = -1;
					// �����ǰС�Ź����в��ܷ�������num����ص�ǰһ��С�Ź���
					if (i > 0) {
						// ��ǰһ���Ź����з�num��λ�����
						if (used[i-1]!=-1) {
							//maps[(int) (Math.floor(used[i-1]/3)+Math.floor((i-1)/3)*3)][used[i-1]%3+((i-1)%3)*3]=-1;
							clearNum(i - 1, num);
						}
						// i����һ������Ϊ�Ȼ�forѭ���Ҹ�i��һ�����������2
						i -= 2;
						continue;
					} else {
						isOk = false;
						return;
					}
				} else {
					// ��num���뵱ǰС�Ź�����
					boolean flag = false;
					while (!flag) {
						int j = (int) (Math.random() * 9);
						// ��ǰС���������
						int ii = (i / 3) * 3 + j / 3;
						// ��ǰС����������
						int jj = (i % 3) * 3 + j % 3;
						//System.out.println("num:"+num+"\tii:"+ii+"\tjj:"+jj);
						// ������Է���num�����
						if (maps[ii][jj] == -1 && j!=used[i] && isCanPut(ii, jj, num)) {
							maps[ii][jj] = num;
							used[i] = j;
							canPutSum[i] -= 1;
							flag = true;
						}
						
					}
				}

			}
		}

	}

	/*
	 * ��յ�i��С�Ź����е�num
	 */
	private static void clearNum(int i, int num) {
		for (int j = 0; j < 9; j++) {
			// ��ǰС���������
			int ii = (i / 3) * 3 + j / 3;
			// ��ǰС����������
			int jj = (i % 3) * 3 + j % 3;
			// �жϵ�ǰС�����Ƿ���Է���
			if (maps[ii][jj] == num) {
				maps[ii][jj] = -1;
			}
		}

	}

	/*
	 * �õ���ǰС�Ź�����Է�������num��λ����Ŀ
	 */
	private static int getCanPutSum(int i, int num) {
		int sum = 0;
		// ����С�Ź���
		for (int j = 0; j < 9; j++) {
			// ��ǰС���������
			int ii = (i / 3) * 3 + j / 3;
			// ��ǰС����������
			int jj = i % 3 * 3 + j % 3;
			// �жϵ�ǰС�����Ƿ���Է���
			if (maps[ii][jj] == -1 && isCanPut(ii, jj, num)) {
				++sum;
			}
		}

		return sum;

	}

	/*
	 * ָ������������Ƿ���Է�ֹnum
	 */
	private static boolean isCanPut(int ii, int jj, int num) {
		// �ж�ָ��������ͬ�л�ͬ���Ƿ�����ͬ���֣�Ҫ������Ϊfalse
		for (int i = 0; i < 9; i++) {
			if (maps[ii][i] == num) {
				return false;
			}
			if (maps[i][jj] == num) {
				return false;
			}
		}
		return true;
	}
}