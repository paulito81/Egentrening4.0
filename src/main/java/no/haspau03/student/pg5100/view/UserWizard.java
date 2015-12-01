package no.haspau03.student.pg5100.view;

import no.haspau03.student.pg5100.model.User;
import org.primefaces.event.FlowEvent;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Paul on 01.12.2015.
 */
@Model
public class UserWizard implements Serializable {



        private User user = new User();

        private boolean skip;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void save() {

            FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getEmail());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        public boolean isSkip() {
            return skip;
        }

        public void setSkip(boolean skip) {

            this.skip = skip;
        }

        public String onFlowProcess(FlowEvent event) {
            if(skip) {
                skip = false;   //reset in case user goes back
                return "confirm";
            }
            else {
                return event.getNewStep();
            }
        }
    }