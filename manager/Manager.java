package cn.hl.manager;

/**
 * 提供学生信息维护的相关方法
 * @author X230
 *
 */
public class Manager {
	private static int no = 1;
	//存储学生信息
	Student[] arr;
	//指针：指向当前的数组索引下标
	int index = -1;
	
	//构造函数
	/**
	 * 无参构造函数
	 * arr的默认初始容量为30个长度
	 */
	public Manager() {
		arr = new Student[30];
	}

	/**
	 * 带参构造函数
	 * arr的初始容量由用户进行自定义
	 * @param count
	 */
	public Manager(int count) {
		arr = new Student[count];
	}
	
	/**
	 * 添加学生信息
	 * @param name
	 * @param gender
	 * @param age
	 * @param grade
	 */
	public void add(String name,char gender, int age,String grade){
		//判断存储空间是否已满
		if(++index == arr.length)
			throw new IndexOutOfBoundsException("已经达到最大学生数量");
		
		//实例化学生对象
		Student stu = new Student(no, name, gender, age,grade);
		//将学生对象存储到数组中
		arr[index] = stu;
		//学号+1
		no++;
	}
	
	/**
	 * 按学号删除学生信息
	 * @param no
	 * @return
	 */
	public boolean delete(int no){
		//调用find()方法查询学生信息在集合中的索引位置
		int idx = find(no);
		
		//判断索引位置是否有效
		if(idx==-1) 
			return false;
		
		//执行移除操作
		//判断学生在集合中的所在位置是否小于最后的元素，如果是则执行移动
		if(idx<index){
			for(int i = idx;i<index;i++){
				arr[i] = arr[i+1];
			}
		}
		//将最后一个元素恢复为默认值，同时index指针前移
		arr[index--] =null;
			
		return true;
	}
	
	
	public boolean edit(int no, String name,int age,char gender,String grade){
		//获取待修改学生信息在集合中的位置
		int idx = find(no);
		//判断学生信息在集合中是否存在，如果不存在则返回false
		if(idx ==-1)
			return false;
		
		//修改学生信息
		arr[idx] .setAge(age);
		arr[idx].setGender(gender);
		arr[idx].setStuName(name);
		arr[idx].setGrade(grade);
		
		return true;
	}
	
	
	
	/**
	 * 按学号查找学生信息在集合中的索引位置
	 * @param no ：待查询学生的学号
	 * @return -1：查找失败
	 */
	private int find(int no){
		//遍历所有的学生对象
		for(int i =0;i<arr.length;i++){
			//判读当前元素是否为null，如果为null则返回-1（无效的索引下标）
			if(arr[i]== null) return -1;
			//如果学生对象不为null，则判断学号是否与待查找学生的学号相等
			//相等则返回元素的索引下标
			if(arr[i].getStuNo() == no){
				return i;
			}
		}
		
		return -1;
	}
	
}
