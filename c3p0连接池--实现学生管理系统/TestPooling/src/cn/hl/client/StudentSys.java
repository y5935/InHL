package cn.hl.client;

import java.util.Scanner;

import cn.hl.bean.Relation;
import cn.hl.bean.User;
import cn.hl.dao.RelationDao;
import cn.hl.dao.StudentDao;
import cn.hl.dao.impl.RelationDaoImpl;
import cn.hl.dao.impl.StudentDaoImpl;
import cn.hl.dao.impl.UserDaoImpl;

/**
 * ��ϰҪ�� 1��ϵͳ�п��Դ洢ѧ����Ϣ���������������Ա����䡢�����༶����ͥסַ����ϵ�绰����ͥ��Ա��Ϣ 2��ϵͳ��Ҫ��������Ҫ��
 * 1����������ϵͳ����������ѧ����Ϣ 2�������԰��հ༶���Ʋ�ѯ���иð��ѧ���б���ʾ
 * 3����ϵͳ�ڿ��Դ洢ÿ��ѧ���Ķ�λ��ͥ��Ա��Ϣ����������ϵ����ϵ�绰�� 4�������԰���ѧ�Ų�ѯָ��ѧ������Ϣ����ͥ��Ա��Ϣ 5�������԰���ѧ���޸�ѧ����Ϣ
 * 6��������ѧ����ѧ�ſ��Բ�ѯ��ǰѧ����״̬(�ڶ�����ѧ����ҵ) 7����ʹ����������ǰ��Ҫ���е�¼��֤
 * 
 * @author Lens
 * 
 */
public class StudentSys {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// ����������洢�������
		int times = 0;
		// ��֤�û���½
		do {
			// ��ʾ�������û�������û���������
			System.out.println("account:");
			String account = input.next();
			System.out.println("pwd:");
			String pwd = input.next();
			// ʵ����Dao����
			UserDaoImpl dao = new UserDaoImpl();
			// ͨ��Dao������е�½��֤
			User user = dao.getByAccount(account, pwd);

			// ��֤��½�Ƿ�ɹ�
			if (user == null) {
				if (++times < 3) {
					System.out
							.println("�û������������ ������" + (3 - times) + "�λ��ᣬ������");
				} else {
					System.err.println("�����������3�Σ�ϵͳ���˳������Ժ�����");
					System.exit(0);
				}
			} else {
				System.out.println(user.getUserName() + ",��ӭ��ʹ��ѧ������ϵͳ");
				break;
			}

		} while (times < 3);
		// �û���¼�ɹ�
		while (true) {
			// 1.���ϵͳ�˵�
			switch (chooseMenuItem()) {
			case 3:
				addRelation();
				break;
			case 7:
				System.out.println("��лʹ��ѧ������ϵͳ");
				System.exit(0);
			default:
				System.out.println("����ѡ������������ѡ��");
				break;

			}
		}
	}

	/**
	 * ��Ӽ�ͥ��Ա��Ϣ
	 * 
	 * ҵ���߼�
	 * 
	 */
	private static void addRelation() {
		StudentDao dao = new StudentDaoImpl();
		while (true) {
			// 1.��ȡ��Ҫ��Ӽ�ͥ��Ա��ѧ��ѧ��
			System.out.println("������ѧ��ѧ�ţ�");
			int stuNo = input.nextInt();
			// 2.��֤ѧ��ѧ���Ƿ���Ч������Students�д���ѧ����Ϣ����Ч�������ʾѧ����Ϣ�����ڣ�
			// ѧ����Ϣ�洢�����ݿ��У�������Ҫͨ�����ݿ������֤
			if (dao.getById(stuNo) == null) {
				System.out.println("ѧ����Ϣ�����ڣ�����������\n");
				continue;
			}

			boolean isFinish = false;
			do {
				// 3.�����Ч���ȡ��ͥ��Ա��Ϣ
				Relation relation = new Relation(stuNo);
				System.out.println("��Ա������");
				relation.setName(input.next());
				System.out.println("��ϵ��");
				relation.setRelation(input.next());
				System.out.println("��ϵ�绰��");
				relation.setTel(input.next());
				// 4.��֤��Ա��Ϣ�����ݱ����Ƿ��Ѿ����ڣ�������ڻ���ʾ�û�
				RelationDao relDao = new RelationDaoImpl();
				if (relDao.checkRelation(stuNo, relation.getName(),
						relation.getRelation())) {
					System.out.println("��ͥ��Ա��Ϣ�Ѿ����ڣ��Ƿ���д������Ա��Ϣ(y/n)");
					char choose = input.next().charAt(0);
					isFinish = (choose == 'y' || choose == 'Y');
					// ������ִ������������ִ��
					if (isFinish)
						continue;
					else
						break;
				}

				// 5.��Ϣ��ӵ����ݿ���
				if (relDao.add(relation) > 0) {
					System.out.print("��ͥ��Ա��ӳɹ�");
				} else {
					System.out.print("��ͥ��Ա���ʧ��");
					
					System.out.print("�Ƿ���д������Ա��Ϣ(y/n)");
					char choose = input.next().charAt(0);
					isFinish = (choose == 'y' || choose == 'Y');
					
				}
			} while (isFinish);
		}

	}

	/**
	 * ����ϵͳ�˵�����ʾ�����û���ѡ��
	 * 
	 * @return
	 */
	private static int chooseMenuItem() {
		System.out.println("--------------��ӭʹ��ѧ������ϵͳ------------");
		System.out.println("1.��Ӱ༶��Ϣ");
		System.out.println("2.���ѧ����Ϣ");
		System.out.println("3.�޸�ѧ����Ϣ");
		System.out.println("4.��Ӽ�ͥ��Ա��Ϣ");
		System.out.println("5.��ѯѧ����Ϣ");
		System.out.println("6.ѧԱת���ˡ��ݣ�ѧ����");
		System.out.println("7.�˳�ϵͳ");
		System.out.println("------------------------------------------");
		System.out.println("��ѡ�����1~7����");
		return input.nextInt();
	}

}
