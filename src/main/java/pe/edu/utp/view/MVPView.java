package pe.edu.utp.view;

import pe.edu.utp.presenter.MVPPresenter;

public interface MVPView {
    public void setPresenter(MVPPresenter presenter);
    
    void showView();
    void hideView();
    Object[] updateView(String subject, Object[] params );
    
    void closeView();
}
