package spring.mvc.reboard;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardDaoInter {

	@Autowired
	SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfReBoard"); //namespace.�� �ٿ��� �ǰ� �Ⱥٿ��� �ȴ�.
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("MaxNumOfReboard");
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		session.update("UpdateStepOfReBoard",map );
	}

	@Override
	public void insertReboard(BoardDto dto) {
		// TODO Auto-generated method stub
		
		int num=dto.getNum();
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0)//����
		{
			regroup=getMaxNum()+1;
			restep=0;
			relevel=0;
			
		}else { //���
			//���� �׷��߿��� ���޹��� restep���� ū �۵��� ��� +1
			this.updateRestep(regroup, restep); //this�� �ϴ� ������ updateRestep �޼��� �ҷ��������� �뵵
			
			//���޹��� step�� level��� 1����
			restep++;
			relevel++;
		}
		
		//�ٲﰪ���� �ٽ� dto�� ��´�.
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//insert
		session.insert("insertOfReboard", dto);
	}

	@Override
	public List<BoardDto> getPagingList(int start, int perpage) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return session.selectList("SelectPagingOfReboard", map);
	}

	@Override
	public BoardDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("getDataOfReboard", num); //@RequestgetParam���� �Ѿ�� num /jsp���� name�Ӽ��� ��Ʈ�ѷ��� �Ѿ��.
	}

	@Override
	public void readCountOfReboard(int num) {
		// TODO Auto-generated method stub
		 session.update("updateReadCountOfReboard", num);
	}

	@Override
	public int getCheckPass(int num, int pass) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>(); //key���� String�� �ȴ�(���ڿ��� �ѱ�� ������). Object �ȉ�
		
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("checkpassEqualOfReboard", map);
	}

	@Override
	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfReboard", dto);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub

		session.delete("deleteOfReboard",num);
	}

}