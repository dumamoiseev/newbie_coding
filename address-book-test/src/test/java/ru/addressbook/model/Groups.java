package ru.addressbook.model;

import com.google.common.collect.ForwardingSet;
import com.sun.jna.platform.win32.LMAccess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xxmoised on 14.11.2016.
 */
public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups() {
      this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate(){

        return delegate;
            }
    public Groups(Collection<GroupData> groups) {
                this.delegate = new HashSet<GroupData>(groups);
           }

}

