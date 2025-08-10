package dao;

import model.Department;
import exception.DepartmentNotFoundException;
import java.util.List;

public interface DepartmentDAO {
    void addDepartment(Department dept);
    Department getDepartmentById(int id) throws DepartmentNotFoundException;
    List<Department> getAllDepartments();
    void updateDepartment(Department dept) throws DepartmentNotFoundException;
    void deleteDepartmentById(int id) throws DepartmentNotFoundException;
}
