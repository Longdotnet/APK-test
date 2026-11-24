create table if not exists public.zyro_mapping_links (
  registration_id uuid primary key,
  zalo_user_id text null,
  zalo_group_id text null,
  zalo_connection_id text null,
  zalo_mapping_status text not null default 'unmapped'
    check (zalo_mapping_status in ('unmapped', 'confirmed', 'synced')),
  zalo_mapped_at timestamptz null,
  zalo_mapped_by text null,
  created_at timestamptz not null default now(),
  updated_at timestamptz not null default now()
);

create index if not exists zyro_mapping_links_uid_idx
  on public.zyro_mapping_links (zalo_user_id)
  where zalo_user_id is not null;

alter table public.zyro_mapping_links enable row level security;

revoke all on table public.zyro_mapping_links from public, anon, authenticated;
grant select, insert, update, delete on table public.zyro_mapping_links to service_role;
