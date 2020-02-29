package pe.edu.utp.ui.presenter;

import pe.edu.utp.ui.model.MVPModel;
import pe.edu.utp.ui.view.MVPView;

public interface MVPPresenter {
    public void setView(MVPView view);
    public void setModel(MVPModel model);
    public void notifyPresenter(String subject, Object[] params );
    public Object[] getResult();
    
}
