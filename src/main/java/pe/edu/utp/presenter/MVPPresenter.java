package pe.edu.utp.presenter;

import pe.edu.utp.model.MVPModel;
import pe.edu.utp.view.MVPView;

public interface MVPPresenter {
    public void setView(MVPView view);
    public void setModel(MVPModel model);
    public void notifyPresenter(String subject, Object[] params );
    public Object[] getResult();
    
}
