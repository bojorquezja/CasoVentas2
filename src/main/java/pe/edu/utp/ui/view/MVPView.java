package pe.edu.utp.ui.view;

import pe.edu.utp.ui.presenter.MVPPresenter;

public interface MVPView {
    public void setPresenter(MVPPresenter presenter);
    
    void showView();
    void hideView();
    Object[] updateView(String subject, Object[] params );
    
    void closeView();
}
