import net.sf.json.JSONObject;

public interface TeacherDao {
    
	/**
	 * 获取所有论文
	 * @return
	 */
	public JSONObject selectAllPapers();
	
	
	/**
	 * 获取所有成绩
	 * @return json数据对象
	 */
    public JSONObject selectAllScores(int eid);
    
    /**
     * 添加学生成绩    
     * @param snum 学生学号
     * @param sname 学生姓名
     * @param score  成绩
     */
    public void insertStudentScore(int sid,int score);
  /**
	 * 查询教师信息
	 * @return 教师对象的集合
	 */
	public List<Staff> selectTeacher();
	/**
	 * 查询教师数据条数
	 * @return 教师数据条数
	 */
	public int selectTeacherCount();
	/**
	 * 删除教师信息
	 * @return 是否成功的标志位
	 */
	public int deleteTeacher(int eid);
	/**
	 * 删除教师角色
	 * @return 是否成功的标志位
	 */
	public int deleteTeacherRole(int eid);
}
